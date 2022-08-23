package sodikov.ak.chatsample.dialog.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import sodikov.ak.chatsample.databinding.FragmentDialogDetailBinding
import sodikov.ak.chatsample.dialog.adapter.DialogDetailAdapter

class DialogDetailFragment : Fragment() {
    private lateinit var binding: FragmentDialogDetailBinding
    private val mViewModel: DialogDetailViewModel by lazy {
        ViewModelProvider(this)[DialogDetailViewModel::class.java]
    }
    private val mAdapter by lazy { DialogDetailAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDialogDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = mAdapter
        mViewModel.messageListLiveData.observe(viewLifecycleOwner){
            mAdapter.submitList(it)
        }
    }


    companion object {
        fun newInstance() = DialogDetailFragment()
    }

}