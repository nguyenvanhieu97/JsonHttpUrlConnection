package com.cris.nvh.jsonhttpurlconnection.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nvh on 10/31/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubOwner implements Parcelable {

	@SerializedName("login")
	@Expose
	private String mLogin;
	@SerializedName("mId")
	@Expose
	private Integer mId;
	@SerializedName("avatar_url")
	@Expose
	private String mAvatarUrl;
	@SerializedName("site_admin")
	@Expose
	private Boolean mSiteAdmin;

	public final static Parcelable.Creator<GithubOwner> CREATOR = new Creator<GithubOwner>() {
		public GithubOwner createFromParcel(Parcel in) {
			return new GithubOwner(in);
		}

		public GithubOwner[] newArray(int size) {
			return (new GithubOwner[size]);
		}
	};

	// unmarshalling
	protected GithubOwner(Parcel in) {
		this.mLogin = in.readString();
		this.mId = in.readInt();
		this.mAvatarUrl = in.readString();
		this.mSiteAdmin = in.readInt() != 0 ? true : false;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int i) {
		dest.writeString(mLogin);
		dest.writeInt(mId);
		dest.writeString(mAvatarUrl);
		dest.writeInt(mSiteAdmin ? 1 : 0);
	}

	public String getAvatarUrl() {
		return mAvatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		mAvatarUrl = avatarUrl;
	}

	public Boolean getSiteAdmin() {
		return mSiteAdmin;
	}

	public void setSiteAdmin(Boolean siteAdmin) {
		mSiteAdmin = siteAdmin;
	}

	public String getLogin() {
		return mLogin;
	}

	public void setLogin(String login) {
		mLogin = login;
	}

	public Integer getId() {
		return mId;
	}

	public void setId(Integer id) {
		mId = id;
	}
}
