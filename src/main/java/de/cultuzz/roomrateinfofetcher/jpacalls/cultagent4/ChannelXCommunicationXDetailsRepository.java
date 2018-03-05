package de.cultuzz.roomrateinfofetcher.jpacalls.cultagent4;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import de.cultuzz.roomrateinfofetcher.model.ChannelXCommunicationXDetails;

@Transactional
public interface ChannelXCommunicationXDetailsRepository extends JpaRepository<ChannelXCommunicationXDetails, Integer>{
	public List<ChannelXCommunicationXDetails> findByDistributorId(Integer distributorId);
}
