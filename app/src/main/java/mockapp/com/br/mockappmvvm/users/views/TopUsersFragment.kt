package mockapp.com.br.mockappmvvm.users.views


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_top_users.*
import mockapp.com.br.mockappmvvm.R
import mockapp.com.br.mockappmvvm.users.adapters.UsersAdapter
import mockapp.com.br.mockappmvvm.users.data.Status
import mockapp.com.br.mockappmvvm.users.viewmodels.TopUsersViewModel
import javax.inject.Inject

class TopUsersFragment : DaggerFragment(), LifecycleOwner {


    @Inject
    lateinit var usersViewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: TopUsersViewModel

    lateinit var adapter: UsersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProviders.of(this, usersViewModelFactory).get(TopUsersViewModel::class.java)

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_top_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topUsersRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UsersAdapter()

        adapter.clickListener = { user ->
            Toast.makeText(this.context, user.displayName, Toast.LENGTH_SHORT).show()
        }

        topUsersRecyclerView.adapter = adapter

        viewModel.dataLoadStatus().observe(this, Observer {
            it?.let {
                when (it.status) {
                    Status.RUNNING -> swipeRefresh.isRefreshing = true
                    Status.FAILED -> swipeRefresh.isRefreshing = false
                    Status.SUCCESS -> swipeRefresh.isRefreshing = false
                }
            }

        })
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getUserList().observe(this, Observer { result ->
            result?.let {
                adapter.submitList(it)
            }

        })


    }

    companion object {
        fun newInstance(): TopUsersFragment = TopUsersFragment()
        val TAG = "TopUsersFragment"
    }

}
