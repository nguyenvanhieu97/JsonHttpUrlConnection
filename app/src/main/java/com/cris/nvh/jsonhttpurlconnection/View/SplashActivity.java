package com.cris.nvh.jsonhttpurlconnection.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cris.nvh.jsonhttpurlconnection.Model.GithubRepo;
import com.cris.nvh.jsonhttpurlconnection.Presenter.SplashScreenPresenter;
import com.cris.nvh.jsonhttpurlconnection.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by nvh on 10/31/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class SplashActivity extends AppCompatActivity implements ISplashActivity {
	public static final String REPO_LIST = "repo_list";
	public static final String URL = "https://api.github.com/users/google/repos";
	private ProgressBar mProgressBar;
	private SplashScreenPresenter mSplashScreenPresenter;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		mProgressBar = findViewById(R.id.progress_bar);
		mSplashScreenPresenter = new SplashScreenPresenter(this);
		mSplashScreenPresenter.onGetData(URL);
	}

	@Override
	public void onLoadDataSuccessfull(List<GithubRepo> repoList) {
		Toast.makeText(this,
				getString(R.string.load_data_successfull), Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putParcelableArrayListExtra(REPO_LIST, (ArrayList<GithubRepo>) repoList);
		startActivity(intent);
		finish();
	}

	@Override
	public void onLoadDataFailed(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}

	public ProgressBar getProgressBar() {
		return mProgressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		mProgressBar = progressBar;
	}

	public SplashScreenPresenter getSplashScreenPresenter() {
		return mSplashScreenPresenter;
	}

	public void setSplashScreenPresenter(SplashScreenPresenter splashScreenPresenter) {
		mSplashScreenPresenter = splashScreenPresenter;
	}
}
