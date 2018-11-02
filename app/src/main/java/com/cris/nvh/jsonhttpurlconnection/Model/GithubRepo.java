package com.cris.nvh.jsonhttpurlconnection.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nvh on 10/31/18.
 * Contact: toiyeuthethao1997@gmail.com
 */

public class GithubRepo implements Parcelable {

	@SerializedName("id")
	@Expose
	private Integer mId;
	@SerializedName("name")
	@Expose
	private String mName;
	@SerializedName("private")
	@Expose
	private Boolean mPrivate;
	@SerializedName("owner")
	@Expose
	private GithubOwner mGithubOwner;
	@SerializedName("description")
	@Expose
	private String mDescription;
	@SerializedName("size")
	@Expose
	private Integer mSize;
	@SerializedName("default_branch")
	@Expose
	private String mDefaultBranch;

	public final static Parcelable.Creator<GithubRepo> CREATOR = new Creator<GithubRepo>() {

		@SuppressWarnings({
				"unchecked"
		})
		public GithubRepo createFromParcel(Parcel in) {
			return new GithubRepo(in);
		}

		public GithubRepo[] newArray(int size) {
			return (new GithubRepo[size]);
		}

	};

	public int describeContents() {
		return 0;
	}

	protected GithubRepo(Parcel in) {
		this.mId = in.readInt();
		this.mName = in.readString();
		this.mPrivate = in.readInt() != 0 ? true : false;
		this.mGithubOwner = in.readParcelable(GithubOwner.class.getClassLoader());
		this.mDescription = (String) in.readValue(String.class.getClassLoader());
		this.mSize = in.readInt();
		this.mDefaultBranch = in.readString();
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mId);
		dest.writeString(mName);
		dest.writeInt(mPrivate ? 1 : 0);
		dest.writeParcelable(mGithubOwner, 0);
		dest.writeValue(mDescription);
		dest.writeInt(mSize);
		dest.writeString(mDefaultBranch);
	}

	public int getId() {
		return mId;
	}

	public void setId(int id) {
		mId = id;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public boolean isPrivate() {
		return mPrivate;
	}

	public void setPrivate(boolean _private) {
		mPrivate = _private;
	}

	public GithubOwner getOwner() {
		return mGithubOwner;
	}

	public void setOwner(GithubOwner owner) {
		mGithubOwner = owner;
	}

	public Object getDescription() {
		return mDescription;
	}

	public void setDescription(String description) {
		mDescription = description;
	}

	public int getSize() {
		return mSize;
	}

	public void setSize(int size) {
		mSize = size;
	}

	public String getDefaultBranch() {
		return mDefaultBranch;
	}

	public void setDefaultBranch(String defaultBranch) {
		mDefaultBranch = defaultBranch;
	}
}
