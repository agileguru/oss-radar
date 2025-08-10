package com.alacritysys.apps.oss.radar.model;

import java.io.Serializable;
import java.sql.Date;

import com.alacritysys.apps.oss.radar.ApplicationConstants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor //NOSONAR
@Getter
@Setter
@Entity(name = ApplicationConstants.JPA_MAPPPING_ITEM_TABLE_NAME)
public class Item implements Serializable{

	private static final long serialVersionUID = -6459518888020764499L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String itemName = "";
	private String itemDesc = "";
	private String itemUrl = "";
	private Date statusDate = new Date(System.currentTimeMillis());
	private String status = ApplicationConstants.ITEM_STATUS_HOLD;
	
	public Date getStatusDate() { 
		return statusDate; //NOSONAR
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate; //NOSONAR	
	}
}
