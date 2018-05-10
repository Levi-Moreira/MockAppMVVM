package mockapp.com.br.mockappmvvm.users


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import mockapp.com.br.mockappmvvm.R

class TopUsersFragment : DaggerFragment(), LifecycleOwner {


    lateinit var viewModel: TopUsersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this).get(TopUsersViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_users, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getUserList(10).observe(this, Observer { result ->
            result?.data?.forEach { user -> Toast.makeText(this.context, user.displayName, Toast.LENGTH_LONG).show() }
        })


    }

    companion object {
        fun newInstance(): TopUsersFragment = TopUsersFragment()
        val TAG = "TopUsersFragment"
    }

}
