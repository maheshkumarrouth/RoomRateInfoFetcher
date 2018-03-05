package de.cultuzz.roomrateinfofetcher.manager.bestday;

import javax.xml.datatype.DatatypeConfigurationException;

import com.cultagent.mappings.CultuzzCommRS;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;

public interface BestDayManager {
	public CultuzzCommRS fecthBestDayRoomRateInfo(CommunicationDTO communicationDTO) throws DatatypeConfigurationException;
}
