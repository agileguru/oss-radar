package com.alacritysys.apps.oss.radar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alacritysys.apps.oss.radar.ApplicationConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = ApplicationConstants.JPA_MAPPING_CATEGORY_TABLE_NAME)
public class Category implements Serializable {

	private static final long serialVersionUID = -398874733061801883L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String name = "";
	private String description = "";
	private String url = "";
	
	@OneToMany(cascade = CascadeType.ALL ,orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = ApplicationConstants.JPA_MAPPPING_ITEM_TABLE_CATEGORY_ID_COLUMN_NAME)
	private List<Item> items = new ArrayList<>();
}
