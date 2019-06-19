// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;
import java.util.Arrays;

// === xdr source ============================================================

//  struct AccountEntry
//  {
//      AccountID accountID;      // master public key for this account
//      int64 balance;            // in stroops
//      SequenceNumber seqNum;    // last sequence number used for this account
//      uint32 numSubEntries;     // number of sub-entries this account has
//                                // drives the reserve
//      AccountID* inflationDest; // Account to vote for during inflation
//      uint32 flags;             // see AccountFlags
//  
//      string32 homeDomain; // can be used for reverse federation and memo lookup
//  
//      // fields used for signatures
//      // thresholds stores unsigned bytes: [weight of master|low|medium|high]
//      Thresholds thresholds;
//  
//      Signer signers<20>; // possible signers for this account
//  
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      case 1:
//          struct
//          {
//              Liabilities liabilities;
//  
//              union switch (int v)
//              {
//              case 0:
//                  void;
//              }
//              ext;
//          } v1;
//      }
//      ext;
//  };

//  ===========================================================================
public class AccountEntry  {
  public AccountEntry () {}
  private AccountID accountID;
  public AccountID getAccountID() {
    return this.accountID;
  }
  public void setAccountID(AccountID value) {
    this.accountID = value;
  }
  private Int64 balance;
  public Int64 getBalance() {
    return this.balance;
  }
  public void setBalance(Int64 value) {
    this.balance = value;
  }
  private SequenceNumber seqNum;
  public SequenceNumber getSeqNum() {
    return this.seqNum;
  }
  public void setSeqNum(SequenceNumber value) {
    this.seqNum = value;
  }
  private Uint32 numSubEntries;
  public Uint32 getNumSubEntries() {
    return this.numSubEntries;
  }
  public void setNumSubEntries(Uint32 value) {
    this.numSubEntries = value;
  }
  private AccountID inflationDest;
  public AccountID getInflationDest() {
    return this.inflationDest;
  }
  public void setInflationDest(AccountID value) {
    this.inflationDest = value;
  }
  private Uint32 flags;
  public Uint32 getFlags() {
    return this.flags;
  }
  public void setFlags(Uint32 value) {
    this.flags = value;
  }
  private String32 homeDomain;
  public String32 getHomeDomain() {
    return this.homeDomain;
  }
  public void setHomeDomain(String32 value) {
    this.homeDomain = value;
  }
  private Thresholds thresholds;
  public Thresholds getThresholds() {
    return this.thresholds;
  }
  public void setThresholds(Thresholds value) {
    this.thresholds = value;
  }
  private Signer[] signers;
  public Signer[] getSigners() {
    return this.signers;
  }
  public void setSigners(Signer[] value) {
    this.signers = value;
  }
  private AccountEntryExt ext;
  public AccountEntryExt getExt() {
    return this.ext;
  }
  public void setExt(AccountEntryExt value) {
    this.ext = value;
  }
  public static void encode(XdrDataOutputStream stream, AccountEntry encodedAccountEntry) throws IOException{
    AccountID.encode(stream, encodedAccountEntry.accountID);
    Int64.encode(stream, encodedAccountEntry.balance);
    SequenceNumber.encode(stream, encodedAccountEntry.seqNum);
    Uint32.encode(stream, encodedAccountEntry.numSubEntries);
    if (encodedAccountEntry.inflationDest != null) {
    stream.writeInt(1);
    AccountID.encode(stream, encodedAccountEntry.inflationDest);
    } else {
    stream.writeInt(0);
    }
    Uint32.encode(stream, encodedAccountEntry.flags);
    String32.encode(stream, encodedAccountEntry.homeDomain);
    Thresholds.encode(stream, encodedAccountEntry.thresholds);
    int signerssize = encodedAccountEntry.getSigners().length;
    stream.writeInt(signerssize);
    for (int i = 0; i < signerssize; i++) {
      Signer.encode(stream, encodedAccountEntry.signers[i]);
    }
    AccountEntryExt.encode(stream, encodedAccountEntry.ext);
  }
  public static AccountEntry decode(XdrDataInputStream stream) throws IOException {
    AccountEntry decodedAccountEntry = new AccountEntry();
    decodedAccountEntry.accountID = AccountID.decode(stream);
    decodedAccountEntry.balance = Int64.decode(stream);
    decodedAccountEntry.seqNum = SequenceNumber.decode(stream);
    decodedAccountEntry.numSubEntries = Uint32.decode(stream);
    int inflationDestPresent = stream.readInt();
    if (inflationDestPresent != 0) {
    decodedAccountEntry.inflationDest = AccountID.decode(stream);
    }
    decodedAccountEntry.flags = Uint32.decode(stream);
    decodedAccountEntry.homeDomain = String32.decode(stream);
    decodedAccountEntry.thresholds = Thresholds.decode(stream);
    int signerssize = stream.readInt();
    decodedAccountEntry.signers = new Signer[signerssize];
    for (int i = 0; i < signerssize; i++) {
      decodedAccountEntry.signers[i] = Signer.decode(stream);
    }
    decodedAccountEntry.ext = AccountEntryExt.decode(stream);
    return decodedAccountEntry;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.accountID, this.balance, this.seqNum, this.numSubEntries, this.inflationDest, this.flags, this.homeDomain, this.thresholds, Arrays.hashCode(this.signers), this.ext);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof AccountEntry)) {
      return false;
    }

    AccountEntry other = (AccountEntry) object;
    return Objects.equal(this.accountID, other.accountID) && Objects.equal(this.balance, other.balance) && Objects.equal(this.seqNum, other.seqNum) && Objects.equal(this.numSubEntries, other.numSubEntries) && Objects.equal(this.inflationDest, other.inflationDest) && Objects.equal(this.flags, other.flags) && Objects.equal(this.homeDomain, other.homeDomain) && Objects.equal(this.thresholds, other.thresholds) && Arrays.equals(this.signers, other.signers) && Objects.equal(this.ext, other.ext);
  }

  public static class AccountEntryExt {
    public AccountEntryExt () {}
    Integer v;
    public Integer getDiscriminant() {
      return this.v;
    }
    public void setDiscriminant(Integer value) {
      this.v = value;
    }
    private AccountEntryV1 v1;
    public AccountEntryV1 getV1() {
      return this.v1;
    }
    public void setV1(AccountEntryV1 value) {
      this.v1 = value;
    }
    public static void encode(XdrDataOutputStream stream, AccountEntryExt encodedAccountEntryExt) throws IOException {
    //Xdrgen::AST::Typespecs::Int
    //Integer
    stream.writeInt(encodedAccountEntryExt.getDiscriminant().intValue());
    switch (encodedAccountEntryExt.getDiscriminant()) {
    case 0:
    break;
    case 1:
    AccountEntryV1.encode(stream, encodedAccountEntryExt.v1);
    break;
    }
    }
    public static AccountEntryExt decode(XdrDataInputStream stream) throws IOException {
    AccountEntryExt decodedAccountEntryExt = new AccountEntryExt();
    Integer discriminant = stream.readInt();
    decodedAccountEntryExt.setDiscriminant(discriminant);
    switch (decodedAccountEntryExt.getDiscriminant()) {
    case 0:
    break;
    case 1:
    decodedAccountEntryExt.v1 = AccountEntryV1.decode(stream);
    break;
    }
      return decodedAccountEntryExt;
    }
    @Override
    public int hashCode() {
      return Objects.hashCode(this.v1, this.v);
    }
    @Override
    public boolean equals(Object object) {
      if (object == null || !(object instanceof AccountEntryExt)) {
        return false;
      }

      AccountEntryExt other = (AccountEntryExt) object;
      return Objects.equal(this.v1, other.v1) && Objects.equal(this.v, other.v);
    }

    public static class AccountEntryV1 {
      public AccountEntryV1 () {}
      private Liabilities liabilities;
      public Liabilities getLiabilities() {
        return this.liabilities;
      }
      public void setLiabilities(Liabilities value) {
        this.liabilities = value;
      }
      private AccountEntryV1Ext ext;
      public AccountEntryV1Ext getExt() {
        return this.ext;
      }
      public void setExt(AccountEntryV1Ext value) {
        this.ext = value;
      }
      public static void encode(XdrDataOutputStream stream, AccountEntryV1 encodedAccountEntryV1) throws IOException{
        Liabilities.encode(stream, encodedAccountEntryV1.liabilities);
        AccountEntryV1Ext.encode(stream, encodedAccountEntryV1.ext);
      }
      public static AccountEntryV1 decode(XdrDataInputStream stream) throws IOException {
        AccountEntryV1 decodedAccountEntryV1 = new AccountEntryV1();
        decodedAccountEntryV1.liabilities = Liabilities.decode(stream);
        decodedAccountEntryV1.ext = AccountEntryV1Ext.decode(stream);
        return decodedAccountEntryV1;
      }
      @Override
      public int hashCode() {
        return Objects.hashCode(this.liabilities, this.ext);
      }
      @Override
      public boolean equals(Object object) {
        if (object == null || !(object instanceof AccountEntryV1)) {
          return false;
        }

        AccountEntryV1 other = (AccountEntryV1) object;
        return Objects.equal(this.liabilities, other.liabilities) && Objects.equal(this.ext, other.ext);
      }

      public static class AccountEntryV1Ext {
        public AccountEntryV1Ext () {}
        Integer v;
        public Integer getDiscriminant() {
          return this.v;
        }
        public void setDiscriminant(Integer value) {
          this.v = value;
        }
        public static void encode(XdrDataOutputStream stream, AccountEntryV1Ext encodedAccountEntryV1Ext) throws IOException {
        //Xdrgen::AST::Typespecs::Int
        //Integer
        stream.writeInt(encodedAccountEntryV1Ext.getDiscriminant().intValue());
        switch (encodedAccountEntryV1Ext.getDiscriminant()) {
        case 0:
        break;
        }
        }
        public static AccountEntryV1Ext decode(XdrDataInputStream stream) throws IOException {
        AccountEntryV1Ext decodedAccountEntryV1Ext = new AccountEntryV1Ext();
        Integer discriminant = stream.readInt();
        decodedAccountEntryV1Ext.setDiscriminant(discriminant);
        switch (decodedAccountEntryV1Ext.getDiscriminant()) {
        case 0:
        break;
        }
          return decodedAccountEntryV1Ext;
        }
        @Override
        public int hashCode() {
          return Objects.hashCode(this.v);
        }
        @Override
        public boolean equals(Object object) {
          if (object == null || !(object instanceof AccountEntryV1Ext)) {
            return false;
          }

          AccountEntryV1Ext other = (AccountEntryV1Ext) object;
          return Objects.equal(this.v, other.v);
        }

      }
    }
  }
}
