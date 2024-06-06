package Gmail;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Gmail_Playwright {

	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1536 , 864));
		
		Page Page = context.newPage();
		
		Page.navigate("https://google.in/");
		
		Page.getByText("Gmail").click();
		
		try {
			Page.getByText("Sign in").click();
		} catch (Exception e) {}
		
		Page.getByLabel("Email or phone").fill("Dharakasundar4@gmail.com");
		
		Page.getByText("Next").click();
		
		Page.getByLabel("Enter your password").fill("SUNDAR1234");
		
		Page.querySelector("#passwordNext").click();  // This is Id
		
		Page.getByText("Compose").click();
				
		Page.fill("[aria-label='To recipients']", "revanthsrj004@gmail.com");
		Page.press("[aria-label='To recipients']", "Enter");
		
		Page.getByPlaceholder("Subject").fill("Testing purpose in Playwright");
		
		Page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Message Body")).fill("This is normal mail for Testing process in Playwright Java");
		
		Page.getByLabel("Send ‪(Ctrl-Enter)‬").click();
		
//		playwright.close();
		
	}
}
