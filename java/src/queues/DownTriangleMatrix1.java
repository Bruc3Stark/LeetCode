/**
 * ����ѹ���洢�������Ǿ�����
 */

public class DownTriangleMatrix1 {

	private int rows;// �����Ǿ���������������
	private int element[];// �洢�����Ǿ����һά����

	// ����rows�������Ǿ���Ԫ��Ϊ0
	public DownTriangleMatrix1(int rows) {
		if (rows < 0)
			// �׳���Ч�����쳣
			throw new IllegalArgumentException("����������������" + rows);
		this.rows = rows;
		// rows�������Ǿ���洢rows*(rows+1)/2��Ԫ��
		this.element = new int[rows * (rows + 1) / 2];
	}

	// ����rows�������Ǿ��󣬳�ֵ��mat�ṩ��mat��������˳��洢rows�������Ǿ���
	public DownTriangleMatrix1(int rows, int mat[]) {
		this(rows);
		int n = element.length <= mat.length ? element.length : mat.length;
		for (int i = 0; i < n; i++) {
			this.element[i] = mat[i];
		}
	}

	// ���ؾ����i�е�j��Ԫ��ֵ
	public int get(int i, int j) {
		if (i < 0 || i > this.rows || j < 0 || j > this.rows)
			throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
		return i < j ? 0 : element[i * (i + 1) / 2 + j];// ������ѹ���洢��ַѰ�Ҿ���Ԫ��
	}

	// ���þ����i�к͵�j��Ԫ��ֵΪvalue
	public void set(int i, int j, int value) {
		if (i < 0 || i > this.rows || j < 0 || j > this.rows)
			throw new IndexOutOfBoundsException("����Ԫ�ص��л������Խ��");
		this.element[i * (i + 1) / 2 + j] = value;
	}

	// ���������Ǿ�������Ԫ�ص������ַ��������������
	public String toString() {
		String str = "�����Ǿ���" + this.getClass().getName() + "(" + this.rows
				+ "�� ��: \n";
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.rows; j++)
				str += String.format("%4d", this.get(i, j));
			str += "\n";
		}
		return str;
	}

	// ��ǰ�����Ǿ�����mat������ӣ�this+=mat������ӦԪ����ӣ��ı䵱ǰ����
	public void add(DownTriangleMatrix1 mat) {
		if (this.rows != mat.rows)
			throw new IllegalArgumentException("�������������ͬ���������");
		for (int i = 0; i < this.element.length; i++)
			this.element[i] += mat.element[i];
	}
}
