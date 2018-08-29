package org.sdrc.childinfo.repository.springdatajpa;

import org.sdrc.childinfo.domain.TemplateUploadMeta;
import org.sdrc.childinfo.repository.TemplateUploadMetaRepository;
import org.springframework.data.repository.Repository;

/**
 * @author Pratyush
 *
 */
public interface SpringDataTemplateUploadMetaRepository extends TemplateUploadMetaRepository,Repository<TemplateUploadMeta, Integer> {

}
