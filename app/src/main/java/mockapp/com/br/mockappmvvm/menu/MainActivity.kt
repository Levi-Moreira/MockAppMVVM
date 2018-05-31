package mockapp.com.br.mockappmvvm.menu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import mockapp.com.br.mockappmvvm.R
import mockapp.com.br.mockappmvvm.profile.ProfileFragment
import mockapp.com.br.mockappmvvm.users.views.TopUsersFragment

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_top_users -> {
                title = getString(R.string.title_top_users)
                replaceTopUserFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my_profile -> {
                title = getString(R.string.title_dashboard)
                replaceProfileFragment()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        replaceTopUserFragment()
    }


    private fun replaceTopUserFragment() {

        var fragment: androidx.fragment.app.Fragment? = supportFragmentManager.findFragmentByTag(TopUsersFragment.TAG)

        if (fragment == null) {
            fragment = TopUsersFragment.newInstance()
        }

        val transaction: androidx.fragment.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, TopUsersFragment.TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun replaceProfileFragment() {

        var fragment: androidx.fragment.app.Fragment? = supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)

        if (fragment == null) {
            fragment = ProfileFragment.newInstance()
        }

        val transaction: androidx.fragment.app.FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, ProfileFragment.TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
