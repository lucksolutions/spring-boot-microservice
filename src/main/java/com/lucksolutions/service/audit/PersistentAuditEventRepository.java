package com.lucksolutions.service.audit;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface PersistentAuditEventRepository extends Repository<PersistentAuditEvent, Long> {
	
	public PersistentAuditEvent save(PersistentAuditEvent event);
	
	public Iterable<PersistentAuditEvent> save(Iterable<PersistentAuditEvent> events);
	
	
	/**
	 * Find audit events since the time provided.
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after")
	public List<PersistentAuditEvent> find(@Param("after") Date after);
	
	
	/**
	 * Find audit events since the time provided.
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @param pageable subset of the events that should be returned.
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after")
	public Slice<PersistentAuditEvent> find(@Param("after") Date after, Pageable pageable);
	
	/**
	 * Find audit events since the time provided that were generated by the given principal.
	 * @param principal user who generated the event
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after and principal = :principal")
	public List<PersistentAuditEvent> find(@Param("principal") String principal, @Param("after") Date after);
	
	
	/**
	 * Find audit events since the time provided that were generated by the given principal.
	 * @param principal user who generated the event
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @param pageable subset of the events that should be returned.
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after and principal = :principal")
	public Slice<PersistentAuditEvent> find(@Param("principal") String principal, @Param("after") Date after, Pageable pageable);
	
	/**
	 * Find audit events since the time provided that were generated by the given principal.
	 * @param principal user who generated the event
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @param type type of event
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after and principal = :principal and type = :type")
	public List<PersistentAuditEvent> find(@Param("principal") String principal, @Param("after") Date after, @Param("type") String type);
	
	
	/**
	 * Find audit events since the time provided that were generated by the given principal.
	 * @param principal user who generated the event
	 * @param after timestamp of earliest result required (or {@code null} if
	 * unrestricted)
	 * @param type type of event
	 * @param pageable subset of the events that should be returned.
	 * @return audit events
	 */
	@Query("select ae from PersistentAuditEvent ae where time >= :after and principal = :principal and type = :type")
	public Slice<PersistentAuditEvent> find(@Param("principal") String principal, @Param("after") Date after,
			@Param("type") String type, Pageable pageable);

}
