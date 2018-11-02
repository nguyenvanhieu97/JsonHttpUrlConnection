package com.cris.nvh.jsonhttpurlconnection.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cris.nvh.jsonhttpurlconnection.R;

import java.util.List;

/**
 * Created by nvh on 11/1/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubRepoAdapter extends RecyclerView.Adapter<GithubRepoAdapter.ViewHolder> {
	private List<GithubRepo> mGithubRepos;

	public GithubRepoAdapter(List<GithubRepo> githubRepos) {
		mGithubRepos = githubRepos;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = LayoutInflater.from(viewGroup.getContext())
				.inflate(R.layout.view_holder, viewGroup, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
		viewHolder.bindData(mGithubRepos.get(i));
	}

	@Override
	public int getItemCount() {
		return mGithubRepos == null ? 0 : mGithubRepos.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		private TextView mTextId;
		private TextView mTextName;
		private TextView mTextOwnerLogin;
		private TextView mTextOwnerId;
		private ImageView mImageAvatar;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			mTextId = itemView.findViewById(R.id.text_id);
			mTextName = itemView.findViewById(R.id.text_name);
			mTextOwnerId = itemView.findViewById(R.id.text_owner_id);
			mTextOwnerLogin = itemView.findViewById(R.id.text_owner_login);
			mImageAvatar = itemView.findViewById(R.id.image_owner);
		}

		public void bindData(GithubRepo githubRepo) {
			mTextId.setText(String.valueOf(githubRepo.getId()));
			mTextName.setText(githubRepo.getName());
			mTextOwnerId.setText(String.valueOf(githubRepo.getOwner().getId()));
			mTextOwnerLogin.setText(githubRepo.getOwner().getLogin());
			Glide.with(itemView)
					.load(githubRepo.getOwner().getAvatarUrl())
					.into(mImageAvatar);
		}
	}
}
