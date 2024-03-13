package Application.Views;


public abstract class Menu {

    protected ViewRequestsOperations view;

	public Menu(ViewRequestsOperations view)
	{
		this.view = view;
	}


    public abstract void showMenuList();  
}