package com.gre.todo.repository;

import com.gre.todo.model.ProjectProgress;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Jan_R on 06/05/2017.
 */
public class ProjectProgressRepoImpl implements ProjectProgressRepo
{

	/**
	 * find project's associated buildings, person and status info
	 * @param projectId
	 * @return
	 */
	@Override
	public List<ProjectProgress> findProjectProgressByProjectId(Long projectId)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM ProjectProgress p where p.project.id = :projectId");
	 	query.setParameter("projectId",projectId);
		List<ProjectProgress> resultList = query.getResultList();
		session.close();
		return resultList;
	}
}
