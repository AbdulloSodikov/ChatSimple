package sodikov.ak.chatsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import sodikov.ak.chatsample.databinding.ActivityMainBinding
import sodikov.ak.chatsample.dialog.detail.DialogDetailFragment
import sodikov.ak.chatsample.dialog.list.DialogListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_content, DialogDetailFragment.newInstance())
            .commit()
    }
}