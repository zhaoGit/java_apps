package com.zhaos.specification3;

public abstract class CompositeSpecification implements IUserSpecification {

	// 是否满足条件有实现类实现
	public abstract boolean isSatisfiedBy(User user);
	
	// and操作
	public IUserSpecification and(IUserSpecification spec) {
		return new AndSpecification(this, spec);
	}
	
	// not操作
	public IUserSpecification not() {
		return new NotSpecification(this);
	}

	// or操作
	public IUserSpecification or(IUserSpecification spec) {
		return new OrSpecification(this, spec);
	}
	
	class NotSpecification extends CompositeSpecification {
		// 传递一个规格书
		private IUserSpecification spec;
		public NotSpecification(IUserSpecification _spec) {
			this.spec = _spec;
		}
		
		// not操作
		@Override
		public boolean isSatisfiedBy(User user) {
			return !spec.isSatisfiedBy(user);
		}
	}
	
	class OrSpecification extends CompositeSpecification {

		// 左右两个规格书
		private IUserSpecification left;
		private IUserSpecification right;
		public OrSpecification(IUserSpecification _left, IUserSpecification _right) {
			this.left = _left;
			this.right = _right;
		}

		// or运算
		@Override
		public boolean isSatisfiedBy(User user) {
			return left.isSatisfiedBy(user) || right.isSatisfiedBy(user);
		}
	}

	class AndSpecification extends CompositeSpecification {
		// 传递两个规格书进行and操作
		private IUserSpecification left;
		private IUserSpecification right;

		public AndSpecification(IUserSpecification _left, IUserSpecification _right) {
			this.left = _left;
			this.right = _right;
		}

		// 进行and运算
		@Override
		public boolean isSatisfiedBy(User user) {
			return left.isSatisfiedBy(user) && right.isSatisfiedBy(user);
		}
	}
}