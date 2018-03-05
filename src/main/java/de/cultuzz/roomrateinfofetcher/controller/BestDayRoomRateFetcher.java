package de.cultuzz.roomrateinfofetcher.controller;

import javax.xml.datatype.DatatypeConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cultagent.mappings.CultuzzCommRQ;
import com.cultagent.mappings.CultuzzCommRS;

import de.cultuzz.roomrateinfofetcher.service.ValidationService;

@RestController
@RequestMapping("/roomratefetcher")
public class BestDayRoomRateFetcher {
	
	@Autowired
	private ValidationService validationService;
	
	private static final Logger slf4jLogger = LoggerFactory.getLogger(BestDayRoomRateFetcher.class);
	
	@RequestMapping(value="/bestday",method=RequestMethod.POST,produces=MediaType.APPLICATION_XML_VALUE)
	public CultuzzCommRS bestDayRoomRateFetcher(@RequestBody CultuzzCommRQ cultuzzCommRQ) throws DatatypeConfigurationException{
		slf4jLogger.debug("Search bestDayRoomRateFetcher By {}",cultuzzCommRQ.getVersion());
		return validationService.fetchBestDayRoomRateFetcher(cultuzzCommRQ);
	}
}
