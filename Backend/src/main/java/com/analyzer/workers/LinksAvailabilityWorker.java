package com.analyzer.workers;

import com.analyzer.data.inner.HyperMediaLink;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public class LinksAvailabilityWorker {

	public void updateLinksAvailability(Set<HyperMediaLink> hyperLinks) {
		List<Callable<HyperMediaLink>> callables;

		for (HyperMediaLink hyperLink : hyperLinks) {
		}
	}
}
