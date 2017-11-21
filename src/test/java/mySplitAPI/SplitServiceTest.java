package mySplitAPI;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.myAPI.mySplitAPI.entity.Person;
import com.myAPI.mySplitAPI.entity.SplitGroup;
import com.myAPI.mySplitAPI.entity.SplitRequest;
import com.myAPI.mySplitAPI.entity.SplitResponse;
import com.myAPI.mySplitAPI.entity.SplitValue;
import com.myAPI.mySplitAPI.exception.SplitException;
import com.myAPI.mySplitAPI.service.SplitService;

public class SplitServiceTest {

	SplitService splitService = new SplitService();

	@SuppressWarnings("deprecation")
	@Test
	public void testsplitService() {
		List<Person> groupmembers = Arrays.asList(
				Person.builder().name("Chaitu").email("ssss@ss.com").UOwe(11).IOwe(102).build(),
				Person.builder().name("Girish").email("ssss@ss.com").UOwe(12).IOwe(104).build());
		SplitGroup splitGroup = SplitGroup.builder().splitGroupMembers(groupmembers).build();
		SplitValue splitValue = SplitValue.builder().totalSplitAmount(1002).totalSplitGroupCount(2).build();

		SplitRequest splitRequest = SplitRequest.builder().splitGroup(splitGroup).splitValue(splitValue).build();

		SplitResponse splitResponse = splitService.calculateSplit(splitRequest);

		assertNotNull(splitResponse);
		assertEquals(splitResponse.getSplitResponse().getSplitGroupMembers().size(), 2);
		assertEquals(splitResponse.getSplitResponse().getSplitGroupMembers().get(0).getIOwe(), 603);

	}

	@Test(expected = SplitException.class)
	public void testsplitServiceException() {
		List<Person> groupmembers = Arrays.asList(
				Person.builder().name("Chaitu").email("ssss@ss.com").UOwe(11).IOwe(102).build(),
				Person.builder().name("Girish").email("ssss@ss.com").UOwe(12).IOwe(104).build());
		SplitGroup splitGroup = SplitGroup.builder().splitGroupMembers(groupmembers).build();
		SplitValue splitValue = SplitValue.builder().totalSplitAmount(1002).totalSplitGroupCount(3).build();

		SplitRequest splitRequest = SplitRequest.builder().splitGroup(splitGroup).splitValue(splitValue).build();

		SplitResponse splitResponse = splitService.calculateSplit(splitRequest);

	}

}
