package com.cris.nvh.jsonhttpurlconnection.View;

import com.cris.nvh.jsonhttpurlconnection.Model.GithubRepo;

import java.util.List;

/**
 * Created by nvh on 10/31/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public interface ISplashActivity {
	void onLoadDataSuccessfull(List<GithubRepo> repoList);
	void onLoadDataFailed(String message);
}
