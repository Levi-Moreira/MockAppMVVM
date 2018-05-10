package mockapp.com.br.mockappmvvm.menu

import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import mockapp.com.br.mockappmvvm.R
import mockapp.com.br.mockappmvvm.profile.ProfileFragment
import mockapp.com.br.mockappmvvm.users.TopUsersFragment

class MainActivity : AppCompatActivity() {


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
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

        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(TopUsersFragment.TAG)

        if (fragment == null) {
            fragment = TopUsersFragment.newInstance()
        }

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, TopUsersFragment.TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun replaceProfileFragment() {

        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(ProfileFragment.TAG)

        if (fragment == null) {
            fragment = ProfileFragment.newInstance()
        }

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment, ProfileFragment.TAG)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
