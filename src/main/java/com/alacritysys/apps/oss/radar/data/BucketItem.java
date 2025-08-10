package com.alacritysys.apps.oss.radar.data;

import java.io.Serializable;
import java.sql.Date;

import com.alacritysys.apps.oss.radar.ApplicationConstants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BucketItem implements Serializable {
	private static final long serialVersionUID = 7707298163884766261L;
	
	private Long id ;
	private String bucketItemName = "";
	private String bucketItemDesc = "";
	private String bucketItemUrl = "";
	private Long bucketItemStatusDate = System.currentTimeMillis();
	private String bucketItemStatus = ApplicationConstants.ITEM_STATUS_HOLD;
	private Double positionX = 0.0;
	private Double positionY = 0.0;

	public Date getBucketItemStatusDate() {
		return new Date(this.bucketItemStatusDate);
	}
	public void setBucketItemStatusDate(Date bucketItemStatusDate) {
		this.bucketItemStatusDate = bucketItemStatusDate.getTime();
	}
}
