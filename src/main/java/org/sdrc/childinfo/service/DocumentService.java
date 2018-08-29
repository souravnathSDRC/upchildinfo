package org.sdrc.childinfo.service;

import java.util.List;

public interface DocumentService {
	List<String> searchAllResources(int level);
	List<String> searchAllSop(int level);
	List<String> searchAllAssessmentTools(int level);
	List<String> searchAllUserGuides(int level);
}
