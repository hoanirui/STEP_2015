import static org.junit.Assert.*;

import org.junit.Test;


public class MatrixMultiTest {

	
	@Test
	public void Testsum() {
		assertEquals(450, Matrix.MatrixMulti(3), 0);
		assertEquals(3680, Matrix.MatrixMulti(4), 0);
		assertEquals(18250, Matrix.MatrixMulti(5), 0);
	}

}
