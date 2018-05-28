package com.analyzer.workers;

import com.analyzer.data.inner.HyperMediaLink;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class LinksAvailabilityWorker {

	public void updateLinksAvailability(Set<HyperMediaLink> hyperLinks) {
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		Set<Callable<HyperMediaLink>> callables = new HashSet<>();

		for (HyperMediaLink hyperLink : hyperLinks) {
			callables.add(new CheckLinkWorker(hyperLink));
		}

		try {
			List<Future<HyperMediaLink>> futures = executorService.invokeAll(callables);
			int i = 1;
			int totalLinks = futures.size();
			for (Future<HyperMediaLink> future : futures) {
				System.out.println("Link " + (i) + " / " + totalLinks);
				future.get(5, TimeUnit.SECONDS);
				System.out.println("Link " + (i++) + " is done" );
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
