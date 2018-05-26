package com.analyzer.workers;

import com.analyzer.data.inner.ADisplayRow;
import org.jsoup.nodes.Document;

public interface IWorker {
	ADisplayRow getData(Document doc);
}
