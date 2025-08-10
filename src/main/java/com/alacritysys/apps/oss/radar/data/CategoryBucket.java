package com.alacritysys.apps.oss.radar.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryBucket implements Serializable{
	private static final long serialVersionUID = 2043480160286228818L;
	private Long id;
	private String bucketName;
	private String bucketDesc;
	private String bucketLink;
	private List<BucketItem> items = new ArrayList<>();
}
