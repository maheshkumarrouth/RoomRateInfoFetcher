package de.cultuzz.roomrateinfofetcher.jpamanager.cultagent4;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;

public interface ChannelXCommunicationXDetailsManager {
	public CommunicationDTO findByCommunication(Integer distributorId);
}
