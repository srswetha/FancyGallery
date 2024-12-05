package edu.vt.cs5254.fancygallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import coil.imageLoader
import edu.vt.cs5254.fancygallery.databinding.FragmentGalleryBinding
import kotlinx.coroutines.launch


private const val TAG = "GalleryFragment"

class GalleryFragment: Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding
        get() = checkNotNull(_binding){"FragmentGalleryBinding is null!!!"}

    private val vm: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_gallery, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.reload_menu -> {
                        val imageLoader = context?.imageLoader
                        imageLoader?.memoryCache?.clear()

                        vm.reloadGalleryItems()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                vm.galleryItems.collect { items ->
                    Log.d(TAG, "Response received: ${items.size} items")
                    binding.photoGrid.adapter = GalleryListAdapter(items){ photopageUri ->

                        findNavController()
                            .navigate(GalleryFragmentDirections.showPhoto(photopageUri))



                    }

                }
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}