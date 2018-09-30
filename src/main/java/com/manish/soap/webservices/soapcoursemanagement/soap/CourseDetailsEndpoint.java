package com.manish.soap.webservices.soapcoursemanagement.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.kesri.cources.CourseDetails;
import com.kesri.cources.GetCourseDetailsRequest;
import com.kesri.cources.GetCourseDetailsResponse;
import com.manish.soap.webservices.soapcoursemanagement.soap.bean.Course;
import com.manish.soap.webservices.soapcoursemanagement.soap.service.CourseDetailsService;

@Endpoint
public class CourseDetailsEndpoint {
	
	
	@Autowired
	CourseDetailsService service;
	
@PayloadRoot(namespace="http://kesri.com/cources", localPart="GetCourseDetailsRequest")

	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
		return mapCourse(request);
		
	}

private GetCourseDetailsResponse mapCourse(GetCourseDetailsRequest request) {
	GetCourseDetailsResponse response = new GetCourseDetailsResponse();
	
	Course course = service.findById(request.getId());
	
	CourseDetails courseDetails = new CourseDetails();
	courseDetails.setId(course.getId());
	courseDetails.setName(course.getName());
	courseDetails.setDescription(course.getDescription());
	response.setCourseDetails(courseDetails);
	return response;
}
}
