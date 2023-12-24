package io.refactoring.buckpal;

import com.tngtech.archunit.core.importer.ClassFileImporter;
import io.refactoring.buckpal.archunit.HexagonalArchitecture;
import org.junit.jupiter.api.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

class DependencyRuleTests {

	@Test
	void validateRegistrationContextArchitecture() {
		HexagonalArchitecture.boundedContext("io.refactoring.buckpal.account")

				.withDomainLayer("domain")

				.withAdaptersLayer("adapter")
				.incoming("in.web")
				.outgoing("out.persistence")
				.and()

				.withApplicationLayer("application")
				.services("service")
				.incomingPorts("port.in")
				.outgoingPorts("port.out")
				.and()

				.withConfiguration("configuration")
				.check(new ClassFileImporter()
						.importPackages("io.refactoring.buckpal.."));
	}

	@Test
	void testPackageDependencies() {
		noClasses()
				.that()
				.resideInAPackage("io.refactoring.reviewapp.domain..")
				.should()
				.dependOnClassesThat()
				.resideInAnyPackage("io.refactoring.reviewapp.application..")
				.check(new ClassFileImporter()
						.importPackages("io.refactoring.reviewapp.."));
	}

}
