package com.app.list.view;

public class RowData {

	private int mId;
    private String mTitle;
    private String mDetail;
    private int idImg;
    
    public RowData(int id,String title,String detail,int idImg){
    this.mId=id;
    this.mTitle = title;
    this.mDetail=detail;
    this.idImg=idImg;
 }

	public int getmId() {
		return mId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public String getmDetail() {
		return mDetail;
	}

	public int getIdImg() {
		return idImg;
	}
  
    
}
