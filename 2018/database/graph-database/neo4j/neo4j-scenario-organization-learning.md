# orginization learning

  ```
          = Organization Learning
        :neo4j-version: 2.3.0
        :author: Luanne
        :twitter: @luannem

        :toc:

        Learning Management Systems (LMS) are typically deployed in large organizations to support learning processes that align with business goals
        These systems tie together their employees, organizations, certifications, courses, jobs in order to supplement business strategy.
        This graph gist models a slice of this ecosystem- certification paths and position dependencies on certifications.

        == Domain

        A certification has one or more learning paths.
        A learning path is an ordered sequence of items that must be completed in order to acquire the certification.
        A learning item can be completed by taking a course or proving work experience.
        A course has a delivery type- it can be web based or classroom.
        Work Experience specifies the number of hours one must put in to complete it.
        To acquire a certification, an employee can take take any learning path and complete every item in it.

        Employees hold certifications and complete courses and work experience.
        An employee may fill a position which requires that the incumbent possess certain certifications.

        === Exclusions

        Career paths, employee skills, course pricing, goals, recertification etc.
        Also missing are institutes and instructors (see: http://gist.neo4j.org/?8021580 )

        == Goal

        The model will help us answer the following questions:

        . As an employee, what are the prerequisites for a certification?
        . As an employee, what are the certification paths I can take to be certified in X?
        . As an employee, if I am targeting Position Y, what certifications am I missing?
        . As an organization, which people in my organization are not certified for the positions they hold?
        . As an organization, what are the potential positions available for an employee?

        == Model

        === Entities

        * Certification with attribute name
        * Learning Item with attribute name
        * Course with attributes name and delivery mode
        * Work Experience with attribute hours
        * Position with attribute name
        * Person with attribute name

        Each entity will be labeled according to its type.
        In addition, the delivery mode on a course is modeled as a label.
        For the queries we want to answer above, this is sufficient, there is no need to model the delivery mode as an attribute as well.

        === Relationships

        * A certification has one or more learning paths.
        * A certification is a prerequisite for one or more certifications.
        * A learning path has an ordered list of learning items.
        * A learning item is fulfilled by a course or work experience.
        * A position requires one or more certifications.
        * An employee holds a position.
        * An employee holds one or more certifications.
        * An employee completes one or more courses.
        * An employee completes one or more work experiences.


        A certification path consists of one or more ordered learning items.
        Since a certification can have more than one path, and items on the path can be common, we need a way to identify which items constitute one learning path.
        So a certification path is modelled as a chain where each "next" relation is qualified by the learning path name.

        //image broken due to dropbox
        //.The Path to Certification
        //image::https://dl.dropboxusercontent.com/u/15330610/CertPath.png[]

        Note above that the relation from a certification to its learning items are modeled using the same relation type: `NEXT_LEARNING`.
        This makes it easier to query for an entire path starting at the certification.

        This evolved from a model where a the following is true:

        ----
        (certification)-[:HAS_LEARNING_PATH]->(learningItem)-[:NEXT]->(learningItem)-[:NEXT]->(learningItem)
        ----

        Two relations added no immediate value and more complexity to the kinds of queries targeted, so it was remodeled as a single relation.

        The other relations are self explanatory.

        //image broken due to dropbox
        //.LMS Model
        //image::https://dl.dropboxusercontent.com/u/15330610/LMS-model.jpg[]

        The nice advantage with the schema free property of a graph is the ability to attach any kinds of entities to fulfill learning items and still run the same kinds of queries as you would with a simplified model as above.

        == Setup

        //hide
        //setup
        [source,cypher]
        ----
        CREATE (cert1:Certification { name: "Cert1" })
        CREATE (cert2:Certification { name: "Cert2" })
        CREATE (cert3:Certification { name: "Cert3" })

        CREATE (li1:LearningItem { name: "LearningItem1" })
        CREATE (li2:LearningItem { name: "LearningItem2" })
        CREATE (li3:LearningItem { name: "LearningItem3" })
        CREATE (li4:LearningItem { name: "LearningItem4" })
        CREATE (li5:LearningItem { name: "LearningItem5" })
        CREATE (li6:LearningItem { name: "LearningItem6" })
        CREATE (li7:LearningItem { name: "LearningItem7" })
        CREATE (li8:LearningItem { name: "LearningItem8" })
        CREATE (li9:LearningItem { name: "LearningItem9" })

        CREATE (course1:Course:Classroom { name: "Course1"})
        CREATE (course2:Course:Web { name: "Course2" })
        CREATE (course3:Course:Classroom { name: "Course3" })
        CREATE (course4:Course:Web { name: "Course4" })
        CREATE (course5:Course:Web { name: "Course5" })
        CREATE (course6:Course:Classroom { name: "Course6" })

        CREATE (we1:WorkExp { name: "WorkExp1", hours:100 })
        CREATE (we2:WorkExp { name: "WorkExp2", hours:150 })

        CREATE (pos1:Position { name: "Position1" })
        CREATE (pos2:Position { name: "Position2" })
        CREATE (pos3:Position { name: "Position3" })

        CREATE (person1:Person { name: "Person1" })
        CREATE (person2:Person { name: "Person2" })
        CREATE (person3:Person { name: "Person3" })

        CREATE (cert2)-[:IS_PREREQUISITE]->(cert1)
        CREATE (cert1)-[:IS_PREREQUISITE]->(cert3)

        CREATE (cert1)-[:NEXT_LEARNING {path: "cert1-scheduled"}]->(li1)-[:NEXT_LEARNING {path: "cert1-scheduled"} ]->(li2)-[:NEXT_LEARNING {path: "cert1-scheduled"}]->(li3)
        CREATE (cert1)-[:NEXT_LEARNING {path: "cert1-selfpaced"}]->(li5)-[:NEXT_LEARNING {path: "cert1-selfpaced"}]->(li6)
        CREATE (cert2)-[:NEXT_LEARNING {path: "cert2-scheduled"}]->(li1)-[:NEXT_LEARNING {path: "cert2-scheduled"}]->(li4)
        CREATE (cert3)-[:NEXT_LEARNING {path: "cert3-scheduled"}]->(li7)-[:NEXT_LEARNING {path: "cert3-scheduled"}]->(li8)-[:NEXT_LEARNING {path: "cert3-scheduled"}]->(li9)

        CREATE (li1)-[:FULFILLED_BY]->(course1)
        CREATE (li2)-[:FULFILLED_BY]->(course2)
        CREATE (li3)-[:FULFILLED_BY]->(course3)
        CREATE (li4)-[:FULFILLED_BY]->(we1)
        CREATE (li5)-[:FULFILLED_BY]->(course4)
        CREATE (li6)-[:FULFILLED_BY]->(course2)
        CREATE (li7)-[:FULFILLED_BY]->(we2)
        CREATE (li8)-[:FULFILLED_BY]->(course5)
        CREATE (li9)-[:FULFILLED_BY]->(course6)

        CREATE (pos1)-[:REQUIRES]->(cert2)
        CREATE (pos2)-[:REQUIRES]->(cert1)
        CREATE (pos3)-[:REQUIRES]->(cert1)
        CREATE (pos3)-[:REQUIRES]->(cert3)

        CREATE (person1)-[:HOLDS_POSITION]->(pos1)
        CREATE (person2)-[:HOLDS_POSITION]->(pos2)
        CREATE (person3)-[:HOLDS_POSITION]->(pos3)

        CREATE (person1)-[:HAS_CERTIFICATION {acquiredOn: "2013-12-01"}]->(cert2)
        CREATE (person2)-[:HAS_CERTIFICATION {acquiredOn: "2013-06-15"}]->(cert1)
        CREATE (person2)-[:HAS_CERTIFICATION {acquiredOn: "2011-02-20"}]->(cert3)
        CREATE (person1)-[:COMPLETED {completedOn: "2013-12-01"}]->(course1)
        CREATE (person1)-[:COMPLETED {acquiredOn: "2013-11-15"}]->(we1)
        ----

        == The graph
        [source,cypher]
        ----
        match n return n
        ----
        //graph

        == Queries:

        === What are the prerequisites for Certification 3?

        [source,cypher]
        ----
        MATCH (c:Certification {name:"Cert3"})<-[:IS_PREREQUISITE]-(prereq)
        RETURN prereq.name
        ----
        //table

        === What learning paths does Cert1 have?

        [source,cypher]
        ----
        MATCH p=(c:Certification {name:"Cert1"})-[lp:NEXT_LEARNING*]->(li)-[:FULFILLED_BY]->(f)
        WITH head(lp).path as startPath,lp,p,f
        WHERE ALL (x in lp where x.path=startPath)
        RETURN p
        ----
        //table

        //.Learning paths for Cert1
        //image::https://dl.dropboxusercontent.com/u/15330610/paths1.png[]

        === To be certified in Cert1, which paths can I take which contain only web based courses?

        [source,cypher]
        ----
        MATCH p=(cert:Certification {name:"Cert1"})-[lp:NEXT_LEARNING*]->(li)
        WITH (last(nodes(p))) as lastItem,li,p,lp
        WHERE ((li)-[:FULFILLED_BY]->(:Web)) and (not(lastItem)-[:NEXT_LEARNING]->())
        WITH head(lp).path as startPath,lp,p
        WHERE ALL (x in lp where x.path=startPath)
        RETURN p
        ----
        //table

        //.Attain Cert1 with only web-based courses
        //image::https://dl.dropboxusercontent.com/u/15330610/paths2.png[]

        === What certifications does Person1 need to move up to Position2?

        [source,cypher]
        ----
        MATCH (position:Position {name:"Position2"})-[:REQUIRES]->(cert)
        WITH cert
        MATCH (person:Person {name:"Person1"})
        WITH cert,person
        WHERE NOT(person-[:HAS_CERTIFICATION]->(cert))
        RETURN cert.name as missingCert
        ----
        //table

        === Which people do not hold required certifications for their position?

        [source,cypher]
        ----
        MATCH (person:Person)-[:HOLDS_POSITION]->(position:Position)-[:REQUIRES]->(cert)
        WHERE NOT((person)-[:HAS_CERTIFICATION]->(cert))
        RETURN person.name, COLLECT(cert.name) as missingCerts
        ----
        //table

        === Based on his current certifications, what are the potential positions for Person2?

        [source,cypher]
        ----
        MATCH (person:Person)-[:HAS_CERTIFICATION]->(cert)
        WITH COLLECT(cert) as heldCerts,person
        MATCH (position:Position)-[:REQUIRES]->(requiredCert)
        WHERE NOT((person)-[:HOLDS_POSITION]->(position))
        WITH COLLECT(requiredCert) as requiredCerts,heldCerts,position
        WHERE ALL(rc in requiredCerts where rc in heldCerts)
        RETURN position.name
        ----
        //table

        Created by Luanne Misquitta:

        - link:https://twitter.com/luannem[Twitter]
        - link:http://thought-bytes.blogspot.in/[Blog]
        - link:https://in.linkedin.com/in/luannemisquitta/[LinkedIn]

        //console
  ```

# reference

  - [graphgist-orgnization learning](https://neo4j.com/graphgist/organization-learning )