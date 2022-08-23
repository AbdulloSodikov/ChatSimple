package sodikov.ak.chatsample.dialog.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sodikov.ak.chatsample.dialog.adapter.DialogListAdapter
import sodikov.ak.chatsample.databinding.FragmentDilaogListBinding

class DialogListFragment:Fragment() {
    private var binding:FragmentDilaogListBinding? = null
    private val mBinding get() = binding!!
    private val adapter by lazy { DialogListAdapter() }
    private val viewModes : DialogListViewModel by lazy {
      ViewModelProvider(this)[DialogListViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDilaogListBinding.inflate(inflater,container,false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.recycler.adapter = adapter
       viewModes.dialogs.observe(viewLifecycleOwner){
           adapter.submitList(it)
       }
    }
    companion object {
        fun newInstance() = DialogListFragment()
     }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}