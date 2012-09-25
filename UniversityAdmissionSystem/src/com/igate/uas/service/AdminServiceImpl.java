package com.igate.uas.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.igate.uas.bean.CollegeBean;
import com.igate.uas.bean.DegreeBean;
import com.igate.uas.bean.ProgramScheduledBean;
import com.igate.uas.bean.ProgramsOfferedBean;
import com.igate.uas.dao.AdminDAO;
import com.igate.uas.dao.AdminDAOImpl;
import com.igate.uas.exception.UASException;

public class AdminServiceImpl implements AdminService {

	private AdminDAO adminDAO;

	@Override
	public boolean addCollege(CollegeBean college) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.addCollege(college);

	}

	@Override
	public boolean addDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.addDegree(degree);
	}

	@Override
	public boolean addDegreeToCollege(String collegeId, String degreeId)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.addDegreeToCollege(collegeId, degreeId);
	}

	@Override
	public boolean addProgramToDegree(String collegeId, String degreeId,
			String programId) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.addProgramToDegree(collegeId, degreeId, programId);
	}

	@Override
	public boolean assignMac(String scheduledProgramId, String loginId)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.assignMac(scheduledProgramId, loginId);
	}

	@Override
	public boolean deleteDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.deleteDegree(degree);
	}

	@Override
	public boolean deleteProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.deleteProgram(programsOffered);
	}

	@Override
	public boolean offerProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.offerProgram(programsOffered);
	}

	@Override
	public boolean removeMac(String loginId, String scheduleProgramId)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.removeMac(loginId, scheduleProgramId);
	}

	@Override
	public boolean scheduleProgram(ProgramScheduledBean programScheduled,
			String appPath) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		boolean result = adminDAO.scheduleProgram(programScheduled);
		if (result) {
			createNavigationXML(appPath);
		}
		return result;
	}

	@Override
	public boolean updateDegree(DegreeBean degree) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.updateDegree(degree);
	}

	@Override
	public boolean updateofferProgram(ProgramsOfferedBean programsOffered)
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.updateofferProgram(programsOffered);
	}

	private AdminDAO getDAOObject() {
		if (adminDAO == null)
			adminDAO = new AdminDAOImpl();
		return adminDAO;
	}

	// select methods

	@Override
	public List<CollegeBean> getColleges() throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getColleges();
	}

	@Override
	public List<DegreeBean> getDegrees() throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getDegrees();
	}

	@Override
	public List<ProgramsOfferedBean> getOfferedPrograms() throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getOfferedPrograms();
	}

	@Override
	public List<ProgramScheduledBean> getScheduledPrograms()
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getScheduledPrograms();
	}

	@Override
	public List<ProgramScheduledBean> getScheduledPrograms(Date startDate,
			Date endDate) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getScheduledPrograms(startDate, endDate);
	}

	@Override
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getCollgeDegreeProgram()
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getCollgeDegreeProgram();
	}

	// xml methods

	@Override
	public void createContentXML(
			Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> collegeMap,
			String appPath) throws UASException {
		Document document = getNewDocument();
		Element uasElement = document.createElement("UAS");
		Element programs = document.createElement("Programs");

		for (CollegeBean college : collegeMap.keySet()) {
			for (DegreeBean degree : collegeMap.get(college).keySet()) {
				for (ProgramsOfferedBean program : collegeMap.get(college).get(
						degree)) {

					Element programEle = document.createElement("Program");
					programEle.setAttribute("id", program.getProgramId());

					Element programName = document.createElement("Name");
					programName.setTextContent(program.getProgramName());

					Element degreeEle = document.createElement("Degree");
					degreeEle.setAttribute("id", degree.getDegreeId());
					degreeEle.setTextContent(degree.getDegreeName());

					Element collegeEle = document.createElement("College");
					collegeEle.setAttribute("id", college.getCollegeId());
					collegeEle.setTextContent(college.getCollegeName());

					Element description = document.createElement("Description");
					description.setTextContent(program.getDescription());

					programEle.appendChild(programName);
					programEle.appendChild(degreeEle);
					programEle.appendChild(collegeEle);
					programEle.appendChild(description);

					programs.appendChild(programEle);
				}
			}
		}

		uasElement.appendChild(programs);
		document.appendChild(uasElement);
		System.out.println(appPath + "UASContent.xml");
		this.saveDocument(document, appPath + "UASContent.xml");
	}

	@Override
	public void createNavigationXML(String appPath) throws UASException {
		Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> collegeMap;
		AdminDAO adminDAO = getDAOObject();
		collegeMap = adminDAO.getScheduledProgramsInYear();
		Document document = getNewDocument();
		Element uasElement = document.createElement("UAS");
		Element colleges = document.createElement("Colleges");
		for (CollegeBean college : collegeMap.keySet()) {
			Element collegeEle = document.createElement("College");
			Element collegeName = document.createElement("Name");
			collegeName.setTextContent(college.getCollegeName());
			Element degrees = document.createElement("Degrees");
			for (DegreeBean degree : collegeMap.get(college).keySet()) {
				Element degreeEle = document.createElement("Degree");
				Element degreeName = document.createElement("Name");
				degreeName.setTextContent(degree.getDegreeName());
				Element programs = document.createElement("Courses");
				for (ProgramsOfferedBean program : collegeMap.get(college).get(
						degree)) {
					Element programEle = document.createElement("Course");
					Element programName = document.createElement("Name");
					programName.setTextContent(program.getProgramName());
					Element programId = document.createElement("id");
					programId.setTextContent(program.getProgramId());
					programEle.appendChild(programName);
					programEle.appendChild(programId);

					programs.appendChild(programEle);
				}
				degreeEle.appendChild(degreeName);
				degreeEle.appendChild(programs);

				degrees.appendChild(degreeEle);
			}

			collegeEle.appendChild(collegeName);
			collegeEle.appendChild(degrees);

			colleges.appendChild(collegeEle);
		}

		uasElement.appendChild(colleges);
		document.appendChild(uasElement);
		System.out.println(appPath + "UASContent.xml");
		this.saveDocument(document, appPath + "UASNavigation.xml");

		this.createContentXML(collegeMap, appPath);
	}

	private Document getNewDocument() throws UASException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			return doc;
		} catch (ParserConfigurationException e) {
			throw new UASException(e.getMessage());
		}
	}

	private void saveDocument(Document document, String fileName)
			throws UASException {
		try {
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File(fileName));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			throw new UASException(e.getMessage());
		} catch (TransformerException e) {
			throw new UASException(e.getMessage());
		}
	}

	@Override
	public List<String> macMembers() throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.macMembers();
	}

	@Override
	public Map<CollegeBean, Map<DegreeBean, List<ProgramsOfferedBean>>> getScheduledProgramsInYear()
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getScheduledProgramsInYear();
	}

	@Override
	public Map<String, Map<String, String>> getAssignedMac()
			throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.getAssignedMac();
	}

	@Override
	public boolean updateCollege(CollegeBean college) throws UASException {
		AdminDAO adminDAO = getDAOObject();
		return adminDAO.updateCollege(college);
	}
}
