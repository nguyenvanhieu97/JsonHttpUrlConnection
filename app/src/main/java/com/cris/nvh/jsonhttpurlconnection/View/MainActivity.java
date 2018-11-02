package com.cris.nvh.jsonhttpurlconnection.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cris.nvh.jsonhttpurlconnection.Model.GithubRepo;
import com.cris.nvh.jsonhttpurlconnection.Model.GithubRepoAdapter;
import com.cris.nvh.jsonhttpurlconnection.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private GithubRepoAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayList<GithubRepo> repoList = getIntent()
				.getParcelableArrayListExtra(SplashActivity.REPO_LIST);
		mRecyclerView = findViewById(R.id.recycler_view);
		mLayoutManager = new LinearLayoutManager(this);
		mAdapter = new GithubRepoAdapter(repoList);
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);
	}
}
