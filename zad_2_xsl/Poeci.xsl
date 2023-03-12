<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="CollectionOfPoems">
    <html>
      <head>
        <title>Collection of poems!</title>
      </head>
      <body>
        <h1>Zbiór wierszy</h1>
        <xsl:apply-templates/>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="Poem">
    <article>
      <xsl:apply-templates select="Title" />
      <xsl:apply-templates select="Subtitle" />
      <section>
        <table>
          <tr>
            <td>Author: </td>
            <td><xsl:apply-templates select="Author" /></td>
          </tr>
          <tr>
            <td>Year: </td>
            <td><xsl:apply-templates select="@YearOfPublication" /></td>
          </tr>
          <tr>
            <td>Language: </td>
            <td><xsl:apply-templates select="@Language" /></td>
          </tr>
        </table>
      </section>
      <section>
        <xsl:apply-templates select="Strophe" />
      </section>
    </article>
  </xsl:template>

  <xsl:template match="Title">
    <h2><xsl:value-of select="."/></h2>
  </xsl:template>

  <xsl:template match="Subtitle">
    <h3><xsl:value-of select="."/></h3>
  </xsl:template>

  <xsl:template match="Author">
    <xsl:apply-templates select="FirstName" />&#160;<xsl:apply-templates select="LastName" />
  </xsl:template>

  <xsl:template match="Strophe">
    <p>
      <xsl:apply-templates />
    </p>
  </xsl:template>

  <xsl:template match="Verse">
    <xsl:apply-templates /> <br />
  </xsl:template>
</xsl:stylesheet>