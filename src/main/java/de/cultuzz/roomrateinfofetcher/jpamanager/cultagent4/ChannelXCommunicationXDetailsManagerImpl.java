package de.cultuzz.roomrateinfofetcher.jpamanager.cultagent4;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import de.cultuzz.roomrateinfofetcher.dto.CommunicationDTO;
import de.cultuzz.roomrateinfofetcher.jpacalls.cultagent4.ChannelXCommunicationXDetailsRepository;
import de.cultuzz.roomrateinfofetcher.model.ChannelXCommunicationXDetails;

@Component
public class ChannelXCommunicationXDetailsManagerImpl implements ChannelXCommunicationXDetailsManager{

	@Autowired
	private ChannelXCommunicationXDetailsRepository channelXCommunicationXDetailsRepository;

	@Cacheable(value="channelCommConfig",key="#distributorId")
	public CommunicationDTO findByCommunication(Integer distributorId){
		CommunicationDTO communicationDTO = new CommunicationDTO();
		List<ChannelXCommunicationXDetails> list = channelXCommunicationXDetailsRepository.findByDistributorId(distributorId);
		if(list!=null&&!list.isEmpty()){
			for(Iterator<ChannelXCommunicationXDetails> it= list.iterator();it.hasNext();){
				ChannelXCommunicationXDetails channelXCommunicationXDetails = it.next();
				if(channelXCommunicationXDetails!=null){
					if(channelXCommunicationXDetails.getKey().intValue()==1){
						communicationDTO.setGmUrl(channelXCommunicationXDetails.getValue());
					}else if(channelXCommunicationXDetails.getKey().intValue()==4){
						communicationDTO.setChanneKey(channelXCommunicationXDetails.getValue());
					}
				}
			}
		}
		return communicationDTO;
	}
	
	
	
}
