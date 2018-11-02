package com.cris.nvh.jsonhttpurlconnection.Presenter;

import android.os.AsyncTask;

import com.cris.nvh.jsonhttpurlconnection.Model.GithubRepo;
import com.cris.nvh.jsonhttpurlconnection.R;
import com.cris.nvh.jsonhttpurlconnection.View.SplashActivity;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nvh on 10/31/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class SplashScreenPresenter implements ISplashScreenPresenter {
	public static final int CONNECTION_TIMEOUT = 15000;
	public static final int READ_TIMEOUT = 10000;
	private SplashActivity mSplashActivity;

	public SplashScreenPresenter(SplashActivity splashActivity) {
		mSplashActivity = splashActivity;
	}

	@Override
	public void onGetData(String url) {
		new LoadDataAsyncTask().execute(url);
	}

	public SplashActivity getSplashActivity() {
		return mSplashActivity;
	}

	public void setSplashActivity(SplashActivity splashActivity) {
		mSplashActivity = splashActivity;
	}

	public class LoadDataAsyncTask extends AsyncTask<String, Integer, List<GithubRepo>> {

		@Override
		protected List<GithubRepo> doInBackground(String... strings) {
			String data = getJsonStringData(strings[0]);
			List<GithubRepo> githubRepo = new ArrayList<>();
			try {
				JSONArray jsonArray = new JSONArray(data);
				int arrayLength = jsonArray.length();
				mSplashActivity.getProgressBar().setMax(arrayLength);
				for (int i = 0; i < arrayLength; i++) {
					// marshalling data
					githubRepo.add(new Gson().fromJson(jsonArray.getString(i), GithubRepo.class));
					publishProgress(githubRepo.size());
				}
			} catch (JSONException e) {
				e.printStackTrace();
				mSplashActivity.onLoadDataFailed(
						mSplashActivity.getString(R.string.load_data_failed));
			}
			return githubRepo;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			mSplashActivity.getProgressBar().setProgress(values[0]);
		}

		@Override
		protected void onPostExecute(List<GithubRepo> repoList) {
			super.onPostExecute(repoList);
			mSplashActivity.onLoadDataSuccessfull(repoList);
		}

		public String getJsonStringData(String stringUrl) {
			StringBuilder builder = new StringBuilder();
			try {
				URL url = new URL(stringUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(CONNECTION_TIMEOUT);
				connection.setReadTimeout(READ_TIMEOUT);
				connection.connect();
				InputStreamReader inputStream = new InputStreamReader(
						connection.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStream);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					builder.append(line + "\n");
				}
				bufferedReader.close();
				connection.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				mSplashActivity.onLoadDataFailed(
						mSplashActivity.getString(R.string.load_data_failed));
			} catch (IOException e) {
				e.printStackTrace();
				mSplashActivity.onLoadDataFailed(
						mSplashActivity.getString(R.string.load_data_failed));
			}
			return builder.toString();
		}
	}
}
