package de.hfu.praktikum;

import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import org.junit.rules.Verifier;

import java.util.List;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ResidentServiceTest{
	@Test
	public void getFilteredResidentsTest() {
	
		BaseResidentService testservice = new BaseResidentService();
		testservice.setResidentRepository(new ResidentRepositoryStub());

		Date tmp1 = new Date(1998,3,1);
		Date tmp2 = new Date(1990,12,18);
	
		Resident testpatter1 = new Resident("Simo*", "Messer*", "Bau*", "Furtwangen", tmp1);
		Resident testpatter2 = new Resident("Mo*", "Messer*", "St*", "Heidelberg", tmp2);
		Resident testpatter3 = new Resident("M*", "Messerschm*", "St*", "Heilbronn", tmp2);
	
		List<Resident> testlist1 = testservice.getFilteredResidentsList(testpatter1);
		List<Resident> testlist2 = testservice.getFilteredResidentsList(testpatter2);
		List<Resident> testlist3 = testservice.getFilteredResidentsList(testpatter3);
		assertEquals(0, testlist1.size());
		assertEquals(1, testlist2.size());
		assertEquals(2, testlist3.size());
	}
	@Test
	public void getUniqueResidentTest() throws ResidentServiceException {
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(new ResidentRepositoryStub());
		
		List<Resident> testlist = new ResidentRepositoryStub().getResidents();
		
		Resident testpatter1 = new Resident("Simeon", null ,null, null, null);
		Resident testpatter2 = new Resident(null, "Messerschmidt*", null, null, null);
		Resident testpatter3 = new Resident(null, null, "Steinhofweg 4", null, null);
		
		assertEquals(testlist.get(0).getGivenName(), service.getUniqueResident(testpatter1).getGivenName());
		try {
		assertEquals(testlist.get(1).getFamilyName(), service.getUniqueResident(testpatter2).getFamilyName());
     	} catch (ResidentServiceException a) {
		}
		assertNotEquals(testlist.get(4).getStreet(), service.getUniqueResident(testpatter3).getStreet());
	}
	
	@Test 
	public void easyMockTest() {
		List<Resident> Residents = new ArrayList<Resident>();
		List<Resident> filteredResidents = new ArrayList<Resident>();
		
		Residents.add(new Resident("Simeon", "Messerschmidt", "Baumannstraße 31", "Furtwangen", new Date(1998,3,1)));
		Residents.add(new Resident("Moritz", "Messerschmidt", "Steinhofweg 4", "Heidelberg", new Date(1990,12,18)));
		Residents.add(new Resident("Irina", "Scharschmidt", "Wilhelmstraße 11", "Muenchen", new Date(1988, 2, 25)));
		Residents.add(new Resident("Luca", "Brodbeck", "Auguststraße 22", "Karlsruhe",new Date(2001, 8, 15)));
		Residents.add(new Resident("Marc", "Messerschmidt", "Steinstraße 1", "Heilbronn", new Date(1987, 5, 4)));
		
		Resident filter = new Resident("Moritz", "Messerschmidt", "Steinhofweg 4", "Heidelberg", new Date(1990,12,18));

		
		ResidentRepository repository = createMock(ResidentRepository.class);
		expect(repository.getResidents()).andReturn(Residents);
		replay(repository);
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repository);
		
		List<Resident> result = service.getFilteredResidentsList(filter);
		
		assertThat(result, equalTo(filteredResidents));
	}
	
}