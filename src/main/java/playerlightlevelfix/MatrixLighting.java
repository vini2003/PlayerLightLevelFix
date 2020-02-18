package playerlightlevelfix;

import net.minecraft.client.util.math.Matrix4f;

public class MatrixLighting {
	public static Matrix4f getOn() {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.loadIdentity();
		matrix4f.multiply(Matrix4f.scale(5F, -0.5F, 0.5F));
		return matrix4f;
	}

	public static Matrix4f getOff() {
		Matrix4f matrix4f = new Matrix4f();
		matrix4f.loadIdentity();
		matrix4f.multiply(Matrix4f.scale(3F, -1F, 2F));
		return matrix4f;
	}
}
