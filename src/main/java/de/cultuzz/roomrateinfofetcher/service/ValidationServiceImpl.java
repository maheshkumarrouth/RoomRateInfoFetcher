package de.cultuzz.roomrateinfofetcher.service;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cultagent.mappings.Credentials;
import com.cultagent.mappings.CultuzzCommRQ;
import com.cultagent.mappings.CultuzzCommRS;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;
import de.cultuzz.roomrateinfofetcher.manager.bestday.BestDayManager;

@Component
public class ValidationServiceImpl implements ValidationService{

	@Autowired
	private BestDayManager bestDayManager;
	
	public CommunicationDTO validateCultuzzCommRQ(CultuzzCommRQ cultuzzCommRQ) {
		
		Credentials credentials = cultuzzCommRQ.getMessage().getRelevantObjects().getCltzObject().getCredentials();
        String hotelKey = credentials.getHotelKey();
        String userId = credentials.getUsername();
        String password = credentials.getPassword();
        Integer channelId = cultuzzCommRQ.getMessage().getRelevantObjects().getCltzObject().getDistributorId().intValue();
        CommunicationDTO communicationDTO = new CommunicationDTO();
        communicationDTO.setHotelKey(hotelKey);
        communicationDTO.setUserName(userId);
        communicationDTO.setPassword(password);
        communicationDTO.setDistributorId(channelId);
        
		// TODO Auto-generated method stub
		return communicationDTO;
	}

	public CultuzzCommRS fetchBestDayRoomRateFetcher(CultuzzCommRQ cultuzzCommRQ) throws DatatypeConfigurationException {

		// TODO Auto-generated method stub
		CommunicationDTO communicationDTO = this.validateCultuzzCommRQ(cultuzzCommRQ);
		return bestDayManager.fecthBestDayRoomRateInfo(communicationDTO);
	}
	
}
