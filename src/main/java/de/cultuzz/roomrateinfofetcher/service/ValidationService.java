package de.cultuzz.roomrateinfofetcher.service;

import javax.xml.datatype.DatatypeConfigurationException;

import com.cultagent.mappings.CultuzzCommRQ;
import com.cultagent.mappings.CultuzzCommRS;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;

public interface ValidationService {
	
	public CommunicationDTO validateCultuzzCommRQ(CultuzzCommRQ cultuzzCommRQ);
	
	public CultuzzCommRS fetchBestDayRoomRateFetcher(CultuzzCommRQ cultuzzCommRQ) throws DatatypeConfigurationException;
}
