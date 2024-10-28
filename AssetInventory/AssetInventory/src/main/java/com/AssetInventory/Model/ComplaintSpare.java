package com.AssetInventory.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="complaint_spare")
public class ComplaintSpare {
	

		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		
		@ManyToOne
		@JoinColumn(name="complaint_id")
		private Complaint complaint;
		
		@ManyToOne
		@JoinColumn(name="spare_id")
		private Spare spare;
		
		
		@Column(name="consume_by")
		private String consumeBy;
		
	
		
		@Column(name="consume_date")
		private Date consumeDate;



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public Complaint getComplaint() {
			return complaint;
		}



		public void setComplaint(Complaint complaint) {
			this.complaint = complaint;
		}



		public Spare getSpare() {
			return spare;
		}



		public void setSpare(Spare spare) {
			this.spare = spare;
		}



		public String getConsumeBy() {
			return consumeBy;
		}



		public void setConsumeBy(String consumeBy) {
			this.consumeBy = consumeBy;
		}



		public Date getConsumeDate() {
			return consumeDate;
		}



		public void setConsumeDate(Date consumeDate) {
			this.consumeDate = consumeDate;
		}

		
		
		

}
