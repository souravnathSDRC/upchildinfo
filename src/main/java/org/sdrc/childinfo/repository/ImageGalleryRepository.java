/**
 * 
 */
package org.sdrc.childinfo.repository;

import java.util.List;

import org.sdrc.childinfo.domain.ImageGallery;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Harsh Pratyush (harsh@sdrc.co.in)
 *
 */
public interface ImageGalleryRepository {

	@Transactional
	ImageGallery save(ImageGallery imageGallery);

	List<ImageGallery> findAll();

}
