# Ransomeware Overview

# Ransomeware  Cases

  - [Petya ranomware and NotPetya malware: What you need to know now](https://www.csoonline.com/article/3233210/ransomware/petya-ransomware-and-notpetya-malware-what-you-need-to-know-now.html?nsdr=true )
  
    ```
      Petya and NotPetya are two related pieces of malware that affected thousands
    of computers worldwide in 2016 and 2017. Both Petya and NotPetya aim to encrypt
    the hard drive of infected computers, and there are enough common features
    between the two that NotPetya was originally seen as just a variation on a 
    theme. But NotPetya has many more potential tools to help it spread and infect
    computers, and while Petya is a standard piece of ransomware that aims to make
    few quick Bitcoin from victims, NotPetya is widely viewed as a state-sponsored
    Russian cyberattack masquerading as ransomware.
     The initial version of the Petya malware, which began to spread in March of
    2016, arrives on the victim's computer attached to an email purporting to be
    a job applicaiton's resume. It's a package with two files: an image of young
    man(supposedly of the job applicant,but actually a stock image_ and an 
    executable file, often with "PDF" somewhere in the file name. The plan is to
    get you to click on that file, and to subsequently agree to the Windows User
    Access Control warning that tells you that the executable is going to make
    changes to your computer(Petya only effects Windows computers.
      How Petya works
      If you make the extremely bad decision to agree to this request, Petya will
    reboot your computer. You'll see what looks like the standard Windows CHKDSK
    screen your expect to see after a system crash. In fact, the malware is 
    already working behind the sceens to make your files unreachable. What earned
    Petya the description "the next step in ransomware evolution" despite its 
    initially unimpresseive infection rate is the way it encrypts your files.
    it installs its own boot loader, overwriting the affected system's master
    boot record, then encrypts the master file table, which is the part of the
    filesystem that serves as sort of a roadmap for the hard drive. In essence,
    your files are still there and still unencrypted, but the computer can't 
    access the part of the filesystem that tells it where they are, so they might
    as well be lost. At this point, the ransomeware demands a Bitcoin payment
    in order to decrypt the hard drive.
     As noted, in order to perform this kind of high-level bad behavior, Petya
    needs the user to gullibley agreee to give permission to make admin-level
    changes. A couple of months after Petya first began to spread, a new version
    appeared that was bundled with a second file-encrypting program, dubbed Mischa.
    Mischa kicks in if the user denies Petya admin-level access; it's only a 
    garden-variety piece of ransomware, just encrypting individual files.
    (Unusually, it also encrypts .exe files, which may end up interfering with 
    the vicitim's ablility to pay the ransom.)
      How NotPetya works
      NotPetya speeds on its own. The original Petya required the victim to 
    download it from a spam email, launch it, and give it admin permissions.
    NotPetya exploits serveral different methods to spread without human 
    intervention. The original infection vector appears to be via a backdoor
    planted in M.E.Doc, an accounting software package that's used by almost
    every company Ukraine. Having infected computers form Medoc's servers, 
    NotPetya used a variety of techniques to spread to other cmputers, including
    EternalBlue and EternalRomance, two exploits developed by the United States
    NSA to take advantage a flaw in the Windows implementation of the SMB protocol
    It can also advantage of a tool called MImi Katz to find network administration
    credentials in the infected machine's memory, and then use the PsExec and 
    WMIC tools built into Windows to remotely access other computers on the local
    network and infect them as well.
     NotPetya encrypts everything. The NotPetya malware goes far beyond the original
    Petya trick of encrypting the master boot record, going after a number of 
    other files to seriously screw up your hard drive.
      NotPetya isn't ransomware. This is in fact the most shocking - and important
    thing about NotPetya. It looks like ransomware, complete with a screen informing
    the victim that they can decrypt their files if they send Bitcoin to a specified
    wallet. For Petya, this screen includes an identifying that they're supposed
    to send along with the ransom; the attackters use this code to figure out
    which victim just paid up. But on computers infected with NotPetya, this number
    is just randomly generated and would be of on help in identifying anything.
    And it turns out that in the process of encrypting the data, NotPetya damages
    it beyond repair.
  
    ```

# Reference
 
  - [Ransomware damages rise 15x in 2 years to hit $5 billion in 2017](https://www.csoonline.com/article/3197582/leadership-management/ransomware-damages-rise-15x-in-2-years-to-hit-5-billion-in-2017.html 
  - [Ransomware prevention,protection and recovery: A Blue Team's reference guide](https://www.csoonline.com/article/3046586/ransomware/ransomware-prevention-protection-and-recovery-a-blue-teams-reference-guide.html?nsdr=true)
