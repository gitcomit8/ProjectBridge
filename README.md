# ProjectBridge - Android Application

## Overview

ProjectBridge is an Android marketplace designed to seamlessly connect clients (individuals needing assistance with academic projects and assignments) with talented student freelancers ready to take on those tasks. This platform streamlines the process of posting project requirements by clients and enables freelancers to claim projects on a first-come, first-served basis. Payments are securely managed through a split system: an initial 50% upfront payment via a UPI payment gateway, with the remaining 50% released upon confirmation of hardcopy delivery by platform administrators. A transparent 10% service charge is applied to each transaction, supporting the platform's operation.

This README provides a comprehensive overview of the application's features, a detailed explanation of the dynamic pricing algorithm employed, and essential setup instructions for developers interested in contributing under the terms of the MIT License.

## Features

* **Client Features:**

    * **Project Posting:** Clients can create detailed project listings, specifying requirements, deadlines, subject areas, and any necessary attachments.
    * **Automated Pricing:** Our intelligent algorithm dynamically calculates a fair price for each project based on its complexity, subject, urgency, length, and required skills.
    * **Secure Upfront Payment:** Clients make an initial 50% payment through integrated UPI, ensuring commitment and security for both parties.
    * **Final Payment on Delivery:** The remaining 50% is securely released upon admin verification of the hardcopy delivery to the client.
    * **Automated Receipt Generation:** Clients receive instant, detailed receipts for every payment made.
    * **Project Tracking:** Clients can monitor the status of their projects from posting to completion.
* **Freelancer Features:**

    * **Project Discovery:** Freelancers can easily browse a curated list of available projects matching their skills and interests.
    * **First-Come, First-Served Claiming:** A fair system where the first freelancer to express interest and apply gets assigned to the project.
    * **Clear Project Details:** Comprehensive information about each project is readily available to help freelancers make informed decisions.
    * **Timely Payment Processing:** Secure and timely release of both upfront and final payments upon project milestones.
* **Administrator Features:**

    * **User Management:** Efficiently manage client and freelancer accounts.
    * **Project Oversight:** Monitor all active and completed projects on the platform.
    * **Hardcopy Delivery Verification:** A robust system to confirm the successful delivery of hardcopies to clients, triggering final payment release.
    * **Dispute Resolution:** Tools and processes to mediate and resolve any conflicts between clients and freelancers (Future Enhancement).
    * **Platform Analytics:** Insights into platform usage, transaction volumes, and user activity.

## Pricing Algorithm

ProjectBridge utilizes a sophisticated algorithm to dynamically determine the price of each project, ensuring fairness and reflecting the effort and urgency involved. The calculation is based on the following factors:

**Base Price (BP):** ₹50 (This serves as the starting point for a project of standard characteristics: approximately 700 words, basic complexity, within a general subject area, with a deadline exceeding 7 days, and without specific specialized skills).

The final project price is calculated using the following multi-step formula:


Price = (BP * CM * SM * DM * WCF(WC)) * (1 + (SS_software * 0.10) +(SS_analysis * 0.15) +(SS_domain * 0.20)) * 1.10
**Explanation of the Components:**

1.  **BP (Base Price):** The initial starting cost for a standard project.

2.  **CM (Complexity Multiplier):** Adjusts the price based on the perceived difficulty of the project:

    * Basic: 1.0
    * Intermediate: 1.2
    * Advanced: 1.5
3.  **SM (Subject Multiplier):** Accounts for the specialization and demand of different academic subjects:

    * General Subjects (e.g., English, History): 1.0
    * Technical Subjects (e.g., Computer Science, Engineering): 1.3
    * Specialized Subjects (e.g., Advanced Mathematics, Biotechnology): 1.6
4.  **DM (Deadline Multiplier):** Reflects the urgency of the project completion:

    * > 7 Days: 1.0
    * 3-7 Days: 1.2
    * < 3 Days: 1.5
    * Same Day: 2.0
5.  **WCF(WC) (Word Count Factor):** Modifies the price based on the estimated length (in words) of the project:

    ```
    WCF(WC) =
        if WC <= 300 then 0.5
        else if 301 <= WC <= 500 then 0.8
        else if 501 <= WC <= 700 then 1.0
        else if 701 <= WC <= 1000 then 1.3
        else if 1001 <= WC <= 1500 then 1.6
        else 2.0 + (WC - 1500) * 0.00014
    ```
6.  **Specific Skills Adjustment:** This component increases the price if the project requires specialized skills:

    * **SS\_software:** If the project requires specific software proficiency, the price is increased by 10% (multiplier of 1.10). (Value is 1 if required, 0 otherwise)
    * **SS\_analysis:** If the project demands advanced statistical analysis, the price is increased by 15% (multiplier of 1.15). (Value is 1 if required, 0 otherwise)
    * **SS\_domain:** If the project necessitates specialized domain knowledge (e.g., legal research), the price is increased by 20% (multiplier of 1.20). (Value is 1 if required, 0 otherwise)
7.  **Service Charge:** Finally, a 10% service charge is added to the calculated price to support the platform's operations (multiplied by 1.10).

## Developer Setup

### Prerequisites

* Android Studio (version {Minimum supported version})
* Android SDK (API level {Minimum API Level})
* Java JDK (version {Minimum JDK Version})
* Firebase Account
* UPI Payment Gateway Account (e.g., Razorpay, Paytm)

### Installation

1.  **Clone the Repository**

    ```bash
    git clone [https://github.com/](https://github.com/){your_repo_url}/ProjectBridge.git
    ```
2.  **Open Project in Android Studio**

    * Launch Android Studio.
    * Select "Open an existing Android Studio project".
    * Navigate to the cloned repository and select the `ProjectBridge` folder.
3.  **Set up the SDK**
    * Configure the Android SDK.
4.  **Firebase Configuration**

    * Create a Firebase project on the Firebase Console.
    * Add an Android app to your Firebase project. Follow the instructions to download the `google-services.json` file.
    * Place the `google-services.json` file in the `app/` directory of your Android project.
5.  **Payment Gateway Integration**

    * Sign up for an account with your chosen UPI payment gateway provider.
    * Follow their developer documentation to obtain the necessary API keys and integrate their SDK into your project. Add the required dependencies to your `app/build.gradle` file.
6.  **Build and Run**

    * Build the project in Android Studio (Build > Make Project).
    * Run the app on an Android emulator or a physical device.


## Contributing

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Write your code and tests.
4.  Commit your changes with descriptive commit messages.
5.  Create a pull request to the main branch.


