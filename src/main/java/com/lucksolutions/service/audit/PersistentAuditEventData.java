package com.lucksolutions.service.audit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import com.lucksolutions.service.model.AbstractModelObject;

@Table(name="audit_event_data")
@Data
@Entity
public class PersistentAuditEventData extends AbstractModelObject {

	private static final long serialVersionUID = 6061942298591227441L;

	@Id
	@GeneratedValue
	private String id;
	
	@Column(nullable=false)
	private String dataKey;
	
	@Column(nullable=false)
	@Lob
	private String dataValue;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="event_id")
	private PersistentAuditEvent event;
	
}
